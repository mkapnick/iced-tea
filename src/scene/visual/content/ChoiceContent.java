package scene.visual.content;

import scene.visual.dynamic.described.ChoiceSprite;
import visual.dynamic.described.Stage;

public class ChoiceContent extends Stage {

	private ChoiceSprite option;
	
	public ChoiceContent(int arg0, ChoiceSprite option) {
		super(1);
		this.option = option;
		this.addMouseListener(option);
		// TODO Auto-generated constructor stub
	}

	
	
}
