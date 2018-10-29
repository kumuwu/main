package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.event.ScheduleEvent;

/**
 * An UI component that displays information of a {@code ScheduleEvent}.
 */
public class AppointmentCard extends UiPart<Region> {

    private static final String FXML = "AppointmentCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final ScheduleEvent event;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label eventID;
    @FXML
    private Label datetime;
    @FXML
    private Label personId;
    @FXML
    private Label details;
    @FXML
    private FlowPane tags;

    public AppointmentCard(ScheduleEvent event, int displayedIndex) {
        super(FXML);
        this.event = event;
        id.setText(displayedIndex + ". ");
        eventID.setText(event.getId().toString());
        name.setText(null); //TODO
        datetime.setText(event.getDateToString());
        personId.setText(event.getPersonId().toString());
        details.setText(event.getDetails());
        event.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AppointmentCard)) {
            return false;
        }

        // state check
        AppointmentCard card = (AppointmentCard) other;
        return id.getText().equals(card.id.getText())
                && event.equals(card.event);
    }
}
