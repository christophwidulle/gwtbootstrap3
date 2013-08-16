package com.svenjacobs.gwtbootstrap3.client.ui.base.button;

import com.google.gwt.user.client.ui.HasText;
import com.svenjacobs.gwtbootstrap3.client.ui.HasToggle;
import com.svenjacobs.gwtbootstrap3.client.ui.base.Text;
import com.svenjacobs.gwtbootstrap3.client.ui.base.mixin.ToggleMixin;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.ButtonType;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Styles;
import com.svenjacobs.gwtbootstrap3.client.ui.constants.Toggle;

/**
 * Base class for buttons that can be toggle buttons
 *
 * @author Sven Jacobs
 * @see AbstractButton
 * @see Toggle
 */
public abstract class AbstractToggleButton extends AbstractButton implements HasText, HasToggle {

    private final ToggleMixin toggleMixin = new ToggleMixin(this);
    private final Text textNode = new Text();
    private final Caret caret = new Caret();

    protected AbstractToggleButton() {
        this(ButtonType.DEFAULT);
    }

    protected AbstractToggleButton(final ButtonType type) {
        setType(type);
        add(textNode, getElement());
    }

    @Override
    public void setText(final String text) {
        textNode.setText(text + " ");
    }

    @Override
    public String getText() {
        return textNode.getText();
    }

    /**
     * Specifies that this button acts as a toggle, for instance for a parent {@link com.svenjacobs.gwtbootstrap3.client.ui.DropDown}
     * or {@link com.svenjacobs.gwtbootstrap3.client.ui.ButtonGroup}
     * <p/>
     * Adds a {@link Caret} as a child widget.
     *
     * @param toggle Kind of toggle
     */
    @Override
    public void setToggle(final Toggle toggle) {
        toggleMixin.setToggle(toggle);

        if (toggle == Toggle.DROPDOWN) {
            addStyleName(Styles.DROPDOWN_TOGGLE);

            if (caret.getParent() == null) {
                add(caret, getElement());
            }
        }
    }

    @Override
    public Toggle getToggle() {
        return toggleMixin.getToggle();
    }
}