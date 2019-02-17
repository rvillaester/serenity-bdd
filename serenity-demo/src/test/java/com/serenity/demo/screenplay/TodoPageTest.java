package com.serenity.demo.screenplay;

import static com.serenity.demo.task.DisplayedItems.theDisplayedItems;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.serenity.demo.task.AddItems;
import com.serenity.demo.task.ClearCompletedItems;
import com.serenity.demo.task.CompleteItem;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class TodoPageTest {

    Actor jason = Actor.named("Jason");
    @Managed(uniqueSession = true)
    public WebDriver browser;
    @Steps AddItems addedSomeItems;
    @Steps ClearCompletedItems clearTheCompletedItems;
    
    @Before
    public void jasonBrowseTheWeb() {
    	jason.can(BrowseTheWeb.with(browser));
    }

    @Test
    @Title("Screenplay - Can clear completed TODO items")
    public void canClearCompletedItems() {
    	String item1 = "Learn Serenity";
    	String item2 = "Practice Serenity";
    	
        givenThat(jason).has(addedSomeItems.called(item1, item2));
        when(jason).attemptsTo(
                CompleteItem.called(item1),
                clearTheCompletedItems
        );
        then(jason).should(seeThat(theDisplayedItems(), contains(item2)));
    }
    
}
