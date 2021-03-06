/**
 * Copyright: (c) Syncleus, Inc.
 *
 * You may redistribute and modify this source code under the terms and
 * conditions of the Open Source Community License - Type C version 1.0
 * or any later version as published by Syncleus, Inc. at www.syncleus.com.
 * There should be a copy of the license included with this file. If a copy
 * of the license is not included you are granted no right to distribute or
 * otherwise use this file except through a legal and valid license. You
 * should also contact Syncleus, Inc. at the information below if you cannot
 * find a license:
 *
 * Syncleus, Inc.
 * 2604 South 12th Street
 * Philadelphia, PA 19148
 */

/*
 * Derived from APACHE LICENSE version 2.0 source as indicated at
 * https://github.com/joelittlejohn/embedmongo-maven-plugin as of 5/16/2015.
 * Original source was Copyright (c) 2012 Joe Littlejohn
 */
package com.syncleus.maven.plugins.mongodb;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

public abstract class AbstractMongoMojo extends AbstractMojo {
    /**
     * If true the plugin does nothing at all, allows you to skip from the command line.
     *
     * @since 1.0.0
     */
    @Parameter(property = "mongodb.skip", defaultValue = "false")
    private boolean skip;

    public AbstractMongoMojo() {
    }

    protected AbstractMongoMojo(final boolean skip) {
        this.skip = skip;
    }

    @Override
    public final void execute() throws MojoExecutionException, MojoFailureException {
        if (skip) {
            getLog().debug("skip=true, not starting mongodb");
            return;
        }

        this.start();
    }

    public abstract void start()  throws MojoExecutionException, MojoFailureException;
}
