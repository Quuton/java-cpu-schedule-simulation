package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;
import javax.swing.*;
public class SimulationController extends JPanel {
    JButton resetButton = new JButton("Reset");
    SpinnerNumberModel numberModel = new SpinnerNumberModel(0, 0, 10, 1);
    JSpinner spinnerField = new JSpinner(numberModel);
    JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 1000, 0);
    
    public SimulationController() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints spinnerFieldConstraints = new GridBagConstraints();
        spinnerFieldConstraints.gridx = 1;
        spinnerFieldConstraints.gridy = 0;
        spinnerFieldConstraints.weightx = 0;
        spinnerFieldConstraints.weighty = 0;
        spinnerFieldConstraints.gridheight = 1;
        spinnerFieldConstraints.gridwidth = 1;
        spinnerFieldConstraints.fill = GridBagConstraints.NONE;
        spinnerFieldConstraints.anchor = GridBagConstraints.CENTER;
        spinnerFieldConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(spinnerField, spinnerFieldConstraints);

        GridBagConstraints resetButtonConstraints = new GridBagConstraints();
        resetButtonConstraints.gridx = 0;
        resetButtonConstraints.gridy = 0;
        resetButtonConstraints.weightx = 0;
        resetButtonConstraints.weighty = 0;
        resetButtonConstraints.gridheight = 1;
        resetButtonConstraints.gridwidth = 1;
        resetButtonConstraints.fill = GridBagConstraints.NONE;
        resetButtonConstraints.anchor = GridBagConstraints.CENTER;
        resetButtonConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(resetButton, resetButtonConstraints);

        GridBagConstraints speedSliderConstraints = new GridBagConstraints();
        speedSliderConstraints.gridx = 0;
        speedSliderConstraints.gridy = 1;
        speedSliderConstraints.weightx = 0;
        speedSliderConstraints.weighty = 0;
        speedSliderConstraints.gridheight = 1;
        speedSliderConstraints.gridwidth = 3;
        speedSliderConstraints.fill = GridBagConstraints.NONE;
        speedSliderConstraints.anchor = GridBagConstraints.CENTER;
        speedSliderConstraints.insets = new Insets(10, 10, 10, 10);
        this.add(speedSlider, speedSliderConstraints);
    }
    public void bindResetButtonListener(ActionListener listener) {
        resetButton.addActionListener(listener);
    }
    public void bindSpinnerChangeListener(ChangeListener listener) {
        spinnerField.addChangeListener(listener);
    }
    public void bindSliderChangeListener(ChangeListener listener) {
        speedSlider.addChangeListener(listener);
    }

}
