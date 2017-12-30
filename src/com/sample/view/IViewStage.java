package com.sample.view;

import javafx.scene.Scene;

public interface IViewStage {

	public Scene initScene();
	public void initParent();
	public String getFXML();
}
