package PlayerGUI;

import javax.swing.JButton;

import Common.Theme;

public class ThemeApp extends LevelFrame{
	//JavaDocs!
	
	public ThemeApp(Theme level) {
		super(level);
		title.setText("Theme Name: " + level.getTheme());
		puzzleThemeLightning.setText("Words Left");
		puzzleThemeLightningAttribute.setText(String.valueOf(level.getFoundWords().size()));

	}

	//JavaDocs!
	public JButton getGoBack() {
		return goBack;
	}
	
	//JavaDocs!
	public void restartPTL(Theme level) {
		puzzleThemeLightning.setText(String.valueOf(level.getFoundWords().size() - level.getMovesMadeSize()));
	}

}
