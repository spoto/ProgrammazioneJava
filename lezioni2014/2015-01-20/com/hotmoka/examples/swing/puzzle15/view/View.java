package com.hotmoka.examples.swing.puzzle15.view;

import com.hotmoka.examples.swing.puzzle15.controller.Controller;
import com.hotmoka.examples.swing.puzzle15.model.Model;

public interface View {
	Model getModel();
	void setController(Controller controller);

	// 3: change your display
	void showSolvedDialog();

	// 4: I've changed
	void onConfigurationChange();
}