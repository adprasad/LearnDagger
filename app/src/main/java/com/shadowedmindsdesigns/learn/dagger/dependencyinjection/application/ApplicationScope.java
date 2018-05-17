package com.shadowedmindsdesigns.learn.dagger.dependencyinjection.application;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Used to define what exists globally within the application
 * Not really sure why we need the "@" in front of interface but you get an error otherwise
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
