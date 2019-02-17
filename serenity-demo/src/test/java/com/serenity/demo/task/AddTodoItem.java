package com.serenity.demo.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.RETURN;

import com.serenity.demo.ui.ToDoList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class AddTodoItem implements Performable{
	
	private String item;
	
	protected AddTodoItem(String item) {
		this.item = item;
	}

	@Step("{0} Add item called #item")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
                Enter.theValue(item).into(ToDoList.NEW_TODO_FIELD),
                Hit.the(RETURN).keyIn(ToDoList.NEW_TODO_FIELD)
        );
	}

	public static AddTodoItem called(String item) {
		return instrumented(AddTodoItem.class, item);
	}
}
