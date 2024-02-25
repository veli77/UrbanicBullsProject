/*
 * Copyright (c) 2010-2021, sikuli.org, sikulix.com - MIT license
 */

package org.sikuli.idesupport.syntaxhighlight.style.def;

import java.util.List;

import org.sikuli.idesupport.syntaxhighlight.Def;
import org.sikuli.idesupport.syntaxhighlight.ResolutionException;
import org.sikuli.idesupport.syntaxhighlight.grammar.TokenType;
import org.sikuli.idesupport.syntaxhighlight.style.Style;
import org.sikuli.idesupport.syntaxhighlight.style.StyleElement;

/**
 * @author Tal Liron
 */
public class StyleElementDef extends Def<Style>
{
	//
	// Construction
	//

	public StyleElementDef( String tokenTypeName, List<String> styleElementNames )
	{
		this.tokenTypeName = tokenTypeName;
		this.styleElementNames = styleElementNames;
	}

	//
	// Def
	//

	@Override
	public boolean resolve( Style style ) throws ResolutionException
	{
		TokenType tokenType = TokenType.getTokenTypeByName( tokenTypeName );
		if( tokenType == null )
			throw new ResolutionException( "Unknown token type: " + tokenTypeName );

		//TokenType parent = tokenType.getParent();
		//boolean addToParent = false;
		//if( ( parent != null ) && ( !style.getStyleElements().containsKey( parent ) ) )
			//addToParent = true;
		for( String styleElementName : styleElementNames )
		{
			StyleElement styleElement = StyleElement.getStyleElementByName( styleElementName );
			if( styleElement == null )
				throw new ResolutionException( "Unknown style element: " + styleElementName );

			style.addStyleElement( tokenType, styleElement );
			//if( addToParent )
				//style.addStyleElement( parent, styleElement );
		}

		resolved = true;
		return true;
	}

	// //////////////////////////////////////////////////////////////////////////
	// Private

	private final String tokenTypeName;

	private final List<String> styleElementNames;
}
