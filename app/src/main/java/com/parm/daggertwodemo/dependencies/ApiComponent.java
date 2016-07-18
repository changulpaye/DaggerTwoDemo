package com.parm.daggertwodemo.dependencies;

import com.parm.daggertwodemo.ui.MainActivity;

import dagger.Component;

/**
 * Scope should be the same as dependent Module
 */

@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject(MainActivity activity);
}
