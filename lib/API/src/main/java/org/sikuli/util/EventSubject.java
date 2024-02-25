/*
 * Copyright (c) 2010-2021, sikuli.org, sikulix.com - MIT license
 */
package org.sikuli.util;

/**
 * INTERNAL USE
 */
public interface EventSubject {

  public void addObserver(EventObserver o);

  public void notifyObserver();
}
