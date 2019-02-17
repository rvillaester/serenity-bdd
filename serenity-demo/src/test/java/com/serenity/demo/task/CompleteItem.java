package com.serenity.demo.task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.serenity.demo.ui.ToDoList;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class CompleteItem implements Performable {

    private final String itemName;

    public CompleteItem(String itemName) {
        this.itemName = itemName;
    }

    public static CompleteItem called(String itemName) {
        return instrumented(CompleteItem.class, itemName);
    }

    @Override
    @Step("{0} Completes item called #itemName")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Click.on(ToDoList.completeButtonFor(itemName)));
    }
}
