package com.serenity.demo.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class TodoBox {
    public static Target TODO_FIELD = Target.the("todo field").located(By.id("new-todo"));

}
