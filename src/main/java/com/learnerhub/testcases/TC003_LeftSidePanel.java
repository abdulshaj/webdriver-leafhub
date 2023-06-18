package com.learnerhub.testcases;

import com.framework.testng.api.base.ProjectHooks;
import com.framework.utils.FakerDataFactory;
import com.learnerhub.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_LeftSidePanel extends ProjectHooks {
    @BeforeTest
    public void setValues() {
        testcaseName = "LeftSideBarCheck";
        testDescription = "SideBarcheck";
        authors = "Babu";
        category = "Smoke";
    }

    @Test
    public void runLeftBarCheck() {

        String username = FakerDataFactory.getFirstName();
        String password = "testleaf";

        new LoginPage()
                .enterUsername()
                .enterPassword()
                .clickLogin()
                .verifySideBar();

    }

}
