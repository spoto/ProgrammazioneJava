package com.hotmoka.examples.swing.puzzle15.model;

import com.hotmoka.examples.swing.puzzle15.view.View;

public class TilesModel implements Model {
	private Configuration configuration;
	private View view;

	public TilesModel(Configuration configuration) {
		this.configuration = configuration;
	}

	public int at(int x, int y) {
		return configuration.at(x, y);
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		if (this.configuration != configuration) {
			this.configuration = configuration;
			if (view != null)
				view.onConfigurationChange();
		}
	};

	@Override
	public void setView(View view) {
		this.view = view;
	}
}



