package Builder;


import junit.framework.TestCase;

import Builder.LetterCrazeBuilder;
import BuilderGUI.BuilderApp;
import BuilderGUI.SplashScreen;
import Common.Builder;

public class TestBuilder extends TestCase{
	LetterCrazeBuilder lcb;
	Builder builder;
	BuilderApp builderApp;
	SplashScreen splash;
	
	@Override
	protected void setUp() {
		lcb = new LetterCrazeBuilder();
		builder = new Builder();
		builderApp = new BuilderApp(builder);
		splash = new SplashScreen(builder);
	}
	
	@Override
	protected void tearDown() {
		splash.setEnabled(false);
	}
	
	public void testMain(){
		String[] args = new String[2];
		lcb.main(args);
	}
	public void testInit(){
		this.splash = builderApp.getSplash();
		assertTrue(splash.isVisible());
	}

	

}
