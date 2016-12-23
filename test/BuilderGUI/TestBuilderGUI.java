package BuilderGUI;

import junit.framework.TestCase;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import Builder.LetterCrazeBuilder;
import BuilderControllers.LevelListener;
import BuilderControllers.SubmitWordListener;
import BuilderGUI.BuilderApp;
import BuilderGUI.EditLevels;
import BuilderGUI.MakeNewLevel;
import BuilderGUI.SavedLevels;
import BuilderGUI.SplashScreen;
import BuilderGUI.StartBuilder;
import Common.Builder;

public class TestBuilderGUI extends TestCase {
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
				//at BuilderControllers.TestBuilderControllers.testSplashListener(TestBuilderControllers.java:44)
	//expected:<BuilderGUI.SplashScreen[,0,0,800x600,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]> 
	// but was:<BuilderGUI.SplashScreen[,0,0,800x600,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]>
	
	public void testSplashTime() {
		int splashTime;
		JTextField field = new JTextField();
		//assertEquals(splash, builderApp.getContentPane());
		splashTime = builderApp.getTimeForSplash();
		assertEquals(splashTime, 3);
		try {
			Thread.sleep(splashTime*1000+1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JButton newLvl = builderApp.getStartBuilder().getNewLevel();
		ActionEvent a = new ActionEvent (newLvl, ActionEvent.ACTION_PERFORMED, "press");
		LevelListener ll = new LevelListener(builderApp, builder, newLvl, field, 1);
		try {
			ll.actionPerformed(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testStartBuilderEditLevels() {
		StartBuilder sb = new StartBuilder(builder);
		JButton editLvl =  sb.getEdit();
		JTextField field = new JTextField();
		ActionEvent aEdit = new ActionEvent (editLvl, ActionEvent.ACTION_PERFORMED, "press");
		LevelListener ll = new LevelListener(builderApp, builder, editLvl, field, 1);
		try {
			ll.actionPerformed(aEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EditLevels el = new EditLevels(builder, 1);
		assertEquals(builderApp.getEditLevels().size(), 15);
		builderApp.getSavedLevels().replacePanel();
		SavedLevels sLevels = new SavedLevels(builder);
		JButton removeLvl = sLevels.getDelete().removeFirst();
		assertEquals(removeLvl.isVisible(), false);
		JButton saveLvl = el.getSaveLevel();
		saveLvl.doClick();
		builderApp.getSavedLevels().replacePanel();
		assertEquals(removeLvl.isVisible(), false);
		removeLvl.doClick();
		builderApp.getSavedLevels().replacePanel();
		assertEquals(removeLvl.isVisible(), false);
		MakeNewLevel mnl = new MakeNewLevel(builder);
		assertNull(mnl.getWords().getSelectedValue());
		assertEquals(mnl.getWords().isSelectionEmpty(), true);
		JButton submitWord = el.getAddWord();
		JTextField submit = el.getInputWord();
		submit.setText("hi");
		SubmitWordListener swl = new SubmitWordListener(builderApp, builder, 1);
		ActionEvent aSubmit = new ActionEvent (submitWord, ActionEvent.ACTION_PERFORMED, "submit");
		swl.actionPerformed(aSubmit);
		submitWord.doClick();
	}

}