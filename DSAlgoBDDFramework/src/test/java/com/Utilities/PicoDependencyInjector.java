package com.Utilities;
import com.PageObjects.POM_ArraysPage;
import com.PageObjects.POM_DataStrucIntroPage;
import com.PageObjects.POM_GraphPage;
import com.PageObjects.POM_HomePage;
import com.PageObjects.POM_LinkedListPage;
import com.PageObjects.POM_QueuePage;
import com.PageObjects.POM_RegisterPage;
import com.PageObjects.POM_SignInPage;
import com.PageObjects.POM_StackPage;
import com.PageObjects.POM_TreePage;

public class PicoDependencyInjector {
	/*
	 * In this class we declare the variables that are to be used commonly. Mind that, they
	 * are initialized in their respective classes and pose a state (initialized).
	 * We just declare them in this class so that they can be used across the step
	 * definition classes. */	
	 public POM_HomePage homePage;
	 public	POM_SignInPage signInPage;
	 public POM_RegisterPage registerPage;
	 public POM_GraphPage graphPage;
	 public String homePageTitle;
	 public ExcelReader excelreader;
	 public POM_QueuePage queuePage;
	 public String validUsername;
	 public String validPassword;
	 public String loggedInUsername;
	 public	String registredUserName;
	 public POM_TreePage treePage;
	 public POM_DataStrucIntroPage dataStrIntroPage;
	 public POM_StackPage stackPage;
	 public POM_LinkedListPage linkedListPage;
	 public POM_ArraysPage arraysPage;
}
