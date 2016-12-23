package BuilderControllers;

import junit.framework.TestCase;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Builder.LetterCrazeBuilder;
import BuilderGUI.BuilderApp;
import BuilderGUI.MakeNewLevel;
import BuilderGUI.SplashScreen;
import BuilderGUI.StartBuilder;
import Common.Builder;

public class TestBuilderControllers extends TestCase {
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

	public void testMakeNewLevels() {
		StartBuilder sb = new StartBuilder(builder);
		JButton newLvl =  sb.getNewLevel();
		JTextField field = new JTextField();
		ActionEvent aEdit = new ActionEvent (newLvl, ActionEvent.ACTION_PERFORMED, "press");
		LevelListener ll = new LevelListener(builderApp, builder, newLvl, field, 0);
		try {
			ll.actionPerformed(aEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MakeNewLevel mnl = new MakeNewLevel(builder);
		SelectLevelTypeListener sltl = new SelectLevelTypeListener(builderApp, builder, 0);
		assertEquals(mnl.getLevelType(), "Puzzle");
		for (int i = 0; i < 6; i ++) {
			for (int j = 0; j <6; j++) {
				JButton tile = mnl.getTiles()[i][j];
				assertEquals(tile.isEnabled(), true);
				ItemEvent iClick = new ItemEvent (tile, ItemEvent.ITEM_STATE_CHANGED, "click", ItemEvent.SELECTED);
				sltl.itemStateChanged(iClick);
			}
		}
		JButton previewLvl = mnl.getPreviewButton();
		ActionEvent aPreview = new ActionEvent (previewLvl, ActionEvent.ACTION_PERFORMED, "press");
		PreviewListener pl = new PreviewListener(builderApp, builder, 0);
		try {
			pl.actionPerformed(aPreview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LeavePreviewListener lpl = new LeavePreviewListener(builderApp, builder, 1);
		JButton goBack = mnl.getGoBackButton();
		ActionEvent aGoBack = new ActionEvent (goBack, ActionEvent.ACTION_PERFORMED, "press");
		try {
			lpl.actionPerformed(aGoBack);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SaveListener sl = new SaveListener(builderApp, builder, 0, mnl);
		mnl.resetLevelInfoPanel();
		JButton saveLvl = mnl.getSaveButton();
		ActionEvent aSave = new ActionEvent (saveLvl, ActionEvent.ACTION_PERFORMED, "press");
		try {
			sl.actionPerformed(aSave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JComboBox selectType = mnl.getSelectLevelType();
		ActionEvent aSelectLightning = new ActionEvent (selectType, (int) ActionEvent.MOUSE_EVENT_MASK, "choose lightning");
		try {
			selectType.actionPerformed(aSelectLightning);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mnl.setLevelType("Lightning");
		assertEquals(mnl.getLevelType(), "Lightning");
		ActionEvent aSelectTheme = new ActionEvent(selectType, (int) ActionEvent.MOUSE_EVENT_MASK, "change to theme");
		try {
			selectType.actionPerformed(aSelectTheme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mnl.setLevelType("Theme");
		assertEquals(mnl.getLevelType(), "Theme");
	}

}
