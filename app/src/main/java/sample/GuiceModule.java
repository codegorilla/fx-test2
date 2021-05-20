package sample;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import sample.state.InteractionManager;

class GuiceModule extends AbstractModule {
  @Override
  protected void configure () {
    bind(SpellChecker.class).to(SpellCheckerImpl.class);
    bind(InteractionManager.class).in(Scopes.SINGLETON);
    bind(MainController.class).in(Scopes.SINGLETON);
//    bind(MenubarController.class).in(Scopes.SINGLETON);
//    bind(ToolbarController.class).in(Scopes.SINGLETON);
//    bind(ChartController.class).in(Scopes.SINGLETON);
  }
}
