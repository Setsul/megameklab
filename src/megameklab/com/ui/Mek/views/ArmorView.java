/*
 * MegaMekLab - Copyright (C) 2008
 *
 * Original author - jtighe (torren@users.sourceforge.net)
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package megameklab.com.ui.Mek.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import megamek.common.Mech;
import megameklab.com.util.IView;
import megameklab.com.util.RefreshListener;
import megameklab.com.util.UnitUtil;

public class ArmorView extends IView implements ChangeListener {

    /**
     *
     */
    private static final long serialVersionUID = 799195356642563937L;

    private JPanel mainPanel = new JPanel();

    private JPanel headPanel = new JPanel();
    private JPanel laPanel = new JPanel();
    private JPanel raPanel = new JPanel();
    private JPanel llPanel = new JPanel();
    private JPanel rlPanel = new JPanel();
    private JPanel ltPanel = new JPanel();
    private JPanel rtPanel = new JPanel();
    private JPanel ctPanel = new JPanel();

    private JPanel ltrPanel = new JPanel();
    private JPanel ctrPanel = new JPanel();
    private JPanel rtrPanel = new JPanel();

    private SpinnerNumberModel laArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel raArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel llArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel rlArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel ltArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel rtArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel ctArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel hdArmorModel = new SpinnerNumberModel();

    private SpinnerNumberModel rtrArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel ltrArmorModel = new SpinnerNumberModel();
    private SpinnerNumberModel ctrArmorModel = new SpinnerNumberModel();

    private JSpinner laArmorField = new JSpinner(laArmorModel);
    private JSpinner raArmorField = new JSpinner(raArmorModel);
    private JSpinner llArmorField = new JSpinner(llArmorModel);
    private JSpinner rlArmorField = new JSpinner(rlArmorModel);
    private JSpinner ltArmorField = new JSpinner(ltArmorModel);
    private JSpinner rtArmorField = new JSpinner(rtArmorModel);
    private JSpinner ctArmorField = new JSpinner(ctArmorModel);
    private JSpinner hdArmorField = new JSpinner(hdArmorModel);

    private JSpinner rtrArmorField = new JSpinner(rtrArmorModel);
    private JSpinner ltrArmorField = new JSpinner(ltrArmorModel);
    private JSpinner ctrArmorField = new JSpinner(ctrArmorModel);
    private List<JSpinner> armorFieldList = new ArrayList<JSpinner>();

    private JLabel laArmorMaxLabel = new JLabel();
    private JLabel raArmorMaxLabel = new JLabel();
    private JLabel llArmorMaxLabel = new JLabel();
    private JLabel rlArmorMaxLabel = new JLabel();
    private JLabel ltArmorMaxLabel = new JLabel();
    private JLabel rtArmorMaxLabel = new JLabel();
    private JLabel ctArmorMaxLabel = new JLabel();

    private JLabel ltrArmorMaxLabel = new JLabel();
    private JLabel rtrArmorMaxLabel = new JLabel();
    private JLabel ctrArmorMaxLabel = new JLabel();
    private List<JLabel> armorMaxLabelList = new ArrayList<JLabel>();

    private JLabel currentArmorLabel = new JLabel();
    private JLabel maxArmorLabel = new JLabel();
    private JLabel unallocatedPointsLabel = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsField = new JLabel();

    private JLabel unallocatedPointsLabelPatchworkHead = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkLa = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkLt = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkCt = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkRt = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkRa = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkLl = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkRl = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkCtr = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkLtr = new JLabel("Unallocated:", SwingConstants.TRAILING);
    private JLabel unallocatedPointsLabelPatchworkRtr = new JLabel("Unallocated:", SwingConstants.TRAILING);

    private JLabel unallocatedPointsFieldHead = new JLabel();
    private JLabel unallocatedPointsFieldLa = new JLabel();
    private JLabel unallocatedPointsFieldLt = new JLabel();
    private JLabel unallocatedPointsFieldCt = new JLabel();
    private JLabel unallocatedPointsFieldRt = new JLabel();
    private JLabel unallocatedPointsFieldRa = new JLabel();
    private JLabel unallocatedPointsFieldLl = new JLabel();
    private JLabel unallocatedPointsFieldRl = new JLabel();
    private JLabel unallocatedPointsFieldCtr = new JLabel();
    private JLabel unallocatedPointsFieldLtr = new JLabel();
    private JLabel unallocatedPointsFieldRtr = new JLabel();

    private RefreshListener refresh;

    public ArmorView(Mech unit) {
        super(unit);
        
    	setLayout(new GridLayout(1,1));

        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;

        headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.Y_AXIS));
        laPanel.setLayout(new BoxLayout(laPanel, BoxLayout.Y_AXIS));
        raPanel.setLayout(new BoxLayout(raPanel, BoxLayout.Y_AXIS));
        ltPanel.setLayout(new BoxLayout(ltPanel, BoxLayout.Y_AXIS));
        ctPanel.setLayout(new BoxLayout(ctPanel, BoxLayout.Y_AXIS));
        rtPanel.setLayout(new BoxLayout(rtPanel, BoxLayout.Y_AXIS));
        rtrPanel.setLayout(new BoxLayout(rtrPanel, BoxLayout.Y_AXIS));
        ctrPanel.setLayout(new BoxLayout(ctrPanel, BoxLayout.Y_AXIS));
        ltrPanel.setLayout(new BoxLayout(ltrPanel, BoxLayout.Y_AXIS));

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        mainPanel.add(headPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(laPanel, gbc);
        gbc.gridx = 1;
        mainPanel.add(ltPanel, gbc);
        gbc.gridx = 2;
        mainPanel.add(ctPanel, gbc);
        gbc.gridx = 3;
        mainPanel.add(rtPanel, gbc);
        gbc.gridx = 4;
        mainPanel.add(raPanel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(ltrPanel, gbc);
        gbc.gridx = 2;
        mainPanel.add(ctrPanel, gbc);
        gbc.gridx = 3;
        mainPanel.add(rtrPanel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(llPanel, gbc);
        gbc.gridx = 3;
        mainPanel.add(rlPanel, gbc);

        laArmorField.setName(Integer.toString(Mech.LOC_LARM));
        raArmorField.setName(Integer.toString(Mech.LOC_RARM));
        llArmorField.setName(Integer.toString(Mech.LOC_LLEG));
        rlArmorField.setName(Integer.toString(Mech.LOC_RLEG));
        ltArmorField.setName(Integer.toString(Mech.LOC_LT));
        rtArmorField.setName(Integer.toString(Mech.LOC_RT));
        ctArmorField.setName(Integer.toString(Mech.LOC_CT));
        hdArmorField.setName(Integer.toString(Mech.LOC_HEAD));
        rtrArmorField.setName(Integer.toString(Mech.LOC_RT));
        ltrArmorField.setName(Integer.toString(Mech.LOC_LT));
        ctrArmorField.setName(Integer.toString(Mech.LOC_CT));

        armorFieldList.add(laArmorField);
        armorFieldList.add(raArmorField);
        armorFieldList.add(llArmorField);
        armorFieldList.add(rlArmorField);
        armorFieldList.add(ltArmorField);
        armorFieldList.add(rtArmorField);
        armorFieldList.add(ctArmorField);
        armorFieldList.add(hdArmorField);
        armorFieldList.add(ltrArmorField);
        armorFieldList.add(ctrArmorField);
        armorFieldList.add(rtrArmorField);

        /*Dimension panelSize = new Dimension(75, 75);
        headPanel.setSize(panelSize);
        headPanel.setPreferredSize(panelSize);
        headPanel.setMaximumSize(panelSize);
        headPanel.setMinimumSize(panelSize);*/
        
        Dimension size = new Dimension(35, 20);
        for (JSpinner spinner : armorFieldList) {
            spinner.setToolTipText("Front Armor");
            //you don't set the size of the jspinner, but rather its internal textfield            
            ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setSize(size);
            ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setMaximumSize(size);
            ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setPreferredSize(size);
            ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField().setMinimumSize(size);
        }
        rtrArmorField.setToolTipText("Rear Armor");
        ltrArmorField.setToolTipText("Rear Armor");
        ctrArmorField.setToolTipText("Rear Armor");

        armorMaxLabelList.add(laArmorMaxLabel);
        armorMaxLabelList.add(raArmorMaxLabel);
        armorMaxLabelList.add(llArmorMaxLabel);
        armorMaxLabelList.add(rlArmorMaxLabel);
        armorMaxLabelList.add(ltArmorMaxLabel);
        armorMaxLabelList.add(rtArmorMaxLabel);
        armorMaxLabelList.add(ctArmorMaxLabel);
        armorMaxLabelList.add(ltrArmorMaxLabel);
        armorMaxLabelList.add(ctrArmorMaxLabel);
        armorMaxLabelList.add(rtrArmorMaxLabel);

        Dimension labelSize = new Dimension(15, 20);
        for (JLabel label : armorMaxLabelList) {
            label.setSize(labelSize);
            label.setMaximumSize(labelSize);
            label.setPreferredSize(labelSize);
            label.setMinimumSize(labelSize);
        }

        addAllListeners();

        JPanel masterPanel;

        synchronized (unit) {
            for (int location = 0; location < unit.locations(); location++) {

                switch (location) {
                    case Mech.LOC_HEAD:
                        masterPanel = new JPanel();
                        JPanel topPanel = new JPanel();
                        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
                        JPanel bottomPanel = new JPanel();
                        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
                        topPanel.add(hdArmorField);
                        JLabel label = new JLabel("max: 9", SwingConstants.TRAILING);
                        //label.setSize(labelSize);
                        //label.setMaximumSize(labelSize);
                        //label.setPreferredSize(labelSize);
                        //label.setMinimumSize(labelSize);
                        //topPanel.add(label);
                        masterPanel.add(topPanel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkHead);
                        bottomPanel.add(unallocatedPointsFieldHead);
                        masterPanel.add(bottomPanel);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        headPanel.add(masterPanel);
                        break;
                    case Mech.LOC_LARM:
                        masterPanel = new JPanel();
                        masterPanel.add(laArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(laArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkLa);
                        bottomPanel.add(unallocatedPointsFieldLa);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        laPanel.add(masterPanel);
                        laPanel.add(bottomPanel);
                        break;
                    case Mech.LOC_RARM:
                        masterPanel = new JPanel();
                        masterPanel.add(raArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(raArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkRa);
                        bottomPanel.add(unallocatedPointsFieldRa);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        raPanel.add(masterPanel);
                        raPanel.add(bottomPanel);
                        break;
                    case Mech.LOC_CT:
                        masterPanel = new JPanel();
                        masterPanel.add(ctArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(ctArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkCt);
                        bottomPanel.add(unallocatedPointsFieldCt);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        ctPanel.add(masterPanel);
                        ctPanel.add(bottomPanel);
                        masterPanel = new JPanel();
                        masterPanel.add(ctrArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(ctrArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkCtr);
                        bottomPanel.add(unallocatedPointsFieldCtr);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location) + "(R)", TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        ctrPanel.add(masterPanel);
                        ctrPanel.add(bottomPanel);
                        break;
                    case Mech.LOC_LT:
                        masterPanel = new JPanel();
                        masterPanel.add(ltArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(ltArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkLt);
                        bottomPanel.add(unallocatedPointsFieldLt);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        ltPanel.add(masterPanel);
                        ltPanel.add(bottomPanel);
                        masterPanel = new JPanel();
                        masterPanel.add(ltrArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(ltrArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkLtr);
                        bottomPanel.add(unallocatedPointsFieldLtr);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location) + "(R)", TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        ltrPanel.add(masterPanel);
                        ltrPanel.add(bottomPanel);
                        break;
                    case Mech.LOC_RT:
                        masterPanel = new JPanel();
                        masterPanel.add(rtArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(rtArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkRt);
                        bottomPanel.add(unallocatedPointsFieldRt);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        rtPanel.add(masterPanel);
                        rtPanel.add(bottomPanel);
                        masterPanel = new JPanel();
                        masterPanel.add(rtrArmorField);
                        //masterPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //masterPanel.add(rtrArmorMaxLabel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkRtr);
                        bottomPanel.add(unallocatedPointsFieldRtr);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location) + "(R)", TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        rtrPanel.add(masterPanel);
                        rtrPanel.add(bottomPanel);
                        break;
                    case Mech.LOC_LLEG:
                        masterPanel = new JPanel();
                        topPanel = new JPanel();
                        bottomPanel = new JPanel();
                        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
                        topPanel.add(llArmorField);
                        //topPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //topPanel.add(llArmorMaxLabel);
                        masterPanel.add(topPanel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkLl);
                        bottomPanel.add(unallocatedPointsFieldLl);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        masterPanel.add(bottomPanel);
                        llPanel.add(masterPanel);
                        break;
                    case Mech.LOC_RLEG:
                        masterPanel = new JPanel();
                        topPanel = new JPanel();
                        bottomPanel = new JPanel();
                        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));
                        topPanel.add(rlArmorField);
                        //topPanel.add(new JLabel("/", SwingConstants.TRAILING));
                        //topPanel.add(rlArmorMaxLabel);
                        masterPanel.add(topPanel);
                        bottomPanel = new JPanel();
                        bottomPanel.add(unallocatedPointsLabelPatchworkRl);
                        bottomPanel.add(unallocatedPointsFieldRl);
                        masterPanel.setBorder(BorderFactory.createTitledBorder(null, unit.getLocationAbbr(location), TitledBorder.TOP, TitledBorder.DEFAULT_POSITION));
                        masterPanel.add(bottomPanel);
                        rlPanel.add(masterPanel);
                        break;
                }
            }
        }

        JPanel totalArmorPanel = new JPanel();
        JPanel headerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel pointsPanel = new JPanel();

        totalArmorPanel.setLayout(new BoxLayout(totalArmorPanel, BoxLayout.X_AXIS));
        headerPanel.add(new JLabel("Current/Maximum Armor"));
        bottomPanel.add(currentArmorLabel);
        bottomPanel.add(new JLabel("/", SwingConstants.TRAILING));
        bottomPanel.add(maxArmorLabel);

        unallocatedPointsField.setHorizontalAlignment(SwingConstants.LEADING);
        pointsPanel.add(unallocatedPointsLabel);
        pointsPanel.add(unallocatedPointsField);

        totalArmorPanel.add(headerPanel);
        totalArmorPanel.add(bottomPanel);
        totalArmorPanel.add(pointsPanel);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        mainPanel.add(totalArmorPanel, gbc);
        this.add(mainPanel);
        //this.add(totalArmorPanel);

        // refresh();
    }

    private void addAllListeners() {
        for (JSpinner spinner : armorFieldList) {
            spinner.addChangeListener(this);
        }
    }

    private void removeAllListeners() {
        for (JSpinner spinner : armorFieldList) {
            spinner.removeChangeListener(this);
        }
    }

    public void refresh() {
        removeAllListeners();
        for (int location = 0; location < unit.locations(); location++) {

            int maxArmor = unit.getOInternal(location) * 2;
            switch (location) {
                case Mech.LOC_HEAD:
                    hdArmorModel.setValue(Math.min(9, unit.getArmor(location)));
                    hdArmorModel.setMaximum(9);
                    hdArmorModel.setStepSize(1);
                    hdArmorModel.setMinimum(0);
                    break;
                case Mech.LOC_LARM:
                    laArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    laArmorModel.setMaximum(maxArmor);
                    laArmorModel.setStepSize(1);
                    laArmorModel.setMinimum(0);
                    laArmorMaxLabel.setText(Integer.toString(maxArmor));
                    break;
                case Mech.LOC_RARM:
                    raArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    raArmorModel.setMaximum(maxArmor);
                    raArmorModel.setStepSize(1);
                    raArmorModel.setMinimum(0);
                    raArmorMaxLabel.setText(Integer.toString(maxArmor));
                    break;
                case Mech.LOC_CT:
                    ctArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    ctArmorModel.setMaximum(maxArmor);
                    ctArmorModel.setStepSize(1);
                    ctArmorModel.setMinimum(0);
                    ctrArmorModel.setValue(Math.min(unit.getArmor(location, true), maxArmor - unit.getArmor(location)));
                    ctrArmorModel.setMaximum(maxArmor - unit.getArmor(location));
                    ctrArmorModel.setStepSize(1);
                    ctrArmorModel.setMinimum(0);
                    ctArmorMaxLabel.setText(Integer.toString(maxArmor));
                    ctrArmorMaxLabel.setText(Integer.toString(maxArmor - unit.getArmor(location)));
                    break;
                case Mech.LOC_LT:
                    ltArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    ltArmorModel.setMaximum(maxArmor);
                    ltArmorModel.setStepSize(1);
                    ltArmorModel.setMinimum(0);
                    ltrArmorModel.setValue(Math.min(unit.getArmor(location, true), maxArmor - unit.getArmor(location)));
                    ltrArmorModel.setMaximum(maxArmor - unit.getArmor(location));
                    ltrArmorModel.setStepSize(1);
                    ltrArmorModel.setMinimum(0);
                    ltArmorMaxLabel.setText(Integer.toString(maxArmor));
                    ltrArmorMaxLabel.setText(Integer.toString(maxArmor - unit.getArmor(location)));
                    break;
                case Mech.LOC_RT:
                    rtArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    rtArmorModel.setMaximum(maxArmor);
                    rtArmorModel.setStepSize(1);
                    rtArmorModel.setMinimum(0);
                    rtrArmorModel.setValue(Math.min(unit.getArmor(location, true), maxArmor - unit.getArmor(location)));
                    rtrArmorModel.setMaximum(maxArmor - unit.getArmor(location));
                    rtrArmorModel.setStepSize(1);
                    rtrArmorModel.setMinimum(0);
                    rtArmorMaxLabel.setText(Integer.toString(maxArmor));
                    rtrArmorMaxLabel.setText(Integer.toString(maxArmor - unit.getArmor(location)));
                    break;
                case Mech.LOC_LLEG:
                    llArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    llArmorModel.setMaximum(maxArmor);
                    llArmorModel.setStepSize(1);
                    llArmorModel.setMinimum(0);
                    llArmorMaxLabel.setText(Integer.toString(maxArmor));
                    break;
                case Mech.LOC_RLEG:
                    rlArmorModel.setValue(Math.min(maxArmor, unit.getArmor(location)));
                    rlArmorModel.setMaximum(maxArmor);
                    rlArmorModel.setStepSize(1);
                    rlArmorModel.setMinimum(0);
                    rlArmorMaxLabel.setText(Integer.toString(maxArmor));
                    break;
            }
        }

        currentArmorLabel.setText(Integer.toString(unit.getTotalOArmor()));
        // Total Possible armor is Internal*2 +3 for the extra 3 armor the head
        // can support.
        maxArmorLabel.setText(Integer.toString((unit.getTotalOInternal() * 2) + 3));
        // unallocated armorpoints
        if (unit.hasPatchworkArmor()) {
            unallocatedPointsLabel.setVisible(false);
            unallocatedPointsField.setVisible(false);
            unallocatedPointsLabelPatchworkHead.setVisible(true);
            unallocatedPointsLabelPatchworkLa.setVisible(true);
            unallocatedPointsLabelPatchworkLt.setVisible(true);
            unallocatedPointsLabelPatchworkCt.setVisible(true);
            unallocatedPointsLabelPatchworkRt.setVisible(true);
            unallocatedPointsLabelPatchworkRa.setVisible(true);
            unallocatedPointsLabelPatchworkLl.setVisible(true);
            unallocatedPointsLabelPatchworkRl.setVisible(true);
            unallocatedPointsLabelPatchworkCtr.setVisible(true);
            unallocatedPointsLabelPatchworkLtr.setVisible(true);
            unallocatedPointsLabelPatchworkRtr.setVisible(true);
            unallocatedPointsFieldHead.setVisible(true);
            unallocatedPointsFieldLa.setVisible(true);
            unallocatedPointsFieldLt.setVisible(true);
            unallocatedPointsFieldCt.setVisible(true);
            unallocatedPointsFieldRt.setVisible(true);
            unallocatedPointsFieldRa.setVisible(true);
            unallocatedPointsFieldLl.setVisible(true);
            unallocatedPointsFieldRl.setVisible(true);
            unallocatedPointsFieldHead.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_HEAD, unit.getArmorWeight(Mech.LOC_HEAD)) - unit.getOArmor(Mech.LOC_HEAD)));
            unallocatedPointsFieldLa.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_LARM, unit.getArmorWeight(Mech.LOC_LARM)) - unit.getOArmor(Mech.LOC_LARM)));
            unallocatedPointsFieldLt.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_LT, unit.getArmorWeight(Mech.LOC_LT)) - unit.getOArmor(Mech.LOC_LT)));
            unallocatedPointsFieldCt.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_CT, unit.getArmorWeight(Mech.LOC_CT)) - unit.getOArmor(Mech.LOC_CT)));
            unallocatedPointsFieldRt.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_RT, unit.getArmorWeight(Mech.LOC_RT)) - unit.getOArmor(Mech.LOC_RT)));
            unallocatedPointsFieldRa.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_RARM, unit.getArmorWeight(Mech.LOC_RARM)) - unit.getOArmor(Mech.LOC_RARM)));
            unallocatedPointsFieldLl.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_LLEG, unit.getArmorWeight(Mech.LOC_LLEG)) - unit.getOArmor(Mech.LOC_LLEG)));
            unallocatedPointsFieldRl.setText(Integer.toString(UnitUtil.getArmorPoints(unit, Mech.LOC_RLEG, unit.getArmorWeight(Mech.LOC_RLEG)) - unit.getOArmor(Mech.LOC_RLEG)));
        } else {
            unallocatedPointsLabelPatchworkHead.setVisible(false);
            unallocatedPointsLabelPatchworkLa.setVisible(false);
            unallocatedPointsLabelPatchworkLt.setVisible(false);
            unallocatedPointsLabelPatchworkCt.setVisible(false);
            unallocatedPointsLabelPatchworkRt.setVisible(false);
            unallocatedPointsLabelPatchworkRa.setVisible(false);
            unallocatedPointsLabelPatchworkLl.setVisible(false);
            unallocatedPointsLabelPatchworkRl.setVisible(false);
            unallocatedPointsLabelPatchworkLtr.setVisible(false);
            unallocatedPointsLabelPatchworkRtr.setVisible(false);
            unallocatedPointsLabelPatchworkCtr.setVisible(false);
            unallocatedPointsFieldHead.setVisible(false);
            unallocatedPointsFieldLa.setVisible(false);
            unallocatedPointsFieldLt.setVisible(false);
            unallocatedPointsFieldCt.setVisible(false);
            unallocatedPointsFieldRt.setVisible(false);
            unallocatedPointsFieldRa.setVisible(false);
            unallocatedPointsFieldLl.setVisible(false);
            unallocatedPointsFieldRl.setVisible(false);
            unallocatedPointsLabel.setVisible(true);
            unallocatedPointsField.setVisible(true);
            unallocatedPointsField.setText(Integer.toString(UnitUtil.getArmorPoints(unit, unit.getArmorWeight()) - unit.getTotalOArmor()));
        }
        unallocatedPointsField.setText(Integer.toString(UnitUtil.getArmorPoints(unit, unit.getArmorWeight()) - unit.getTotalOArmor()));
        addAllListeners();
    }

    public void addRefreshedListener(RefreshListener l) {
        refresh = l;
    }

    public void allocateArmor(double tons) {
        double pointsToAllocate = UnitUtil.getArmorPoints(unit, tons);
        double totalArmor = (unit.getTotalOInternal() * 2) + 3;
        if (pointsToAllocate > totalArmor) {
            pointsToAllocate = totalArmor;
        }
        double percent = pointsToAllocate / totalArmor;
        // put 5 times the percentage of total possible armor into the head
        int headArmor = (int) Math.min(Math.floor(percent * 9 * 5), 9);
        unit.initializeArmor(headArmor, Mech.LOC_HEAD);
        pointsToAllocate -= headArmor;
        for (int location = 0; location < unit.locations(); location++) {
            double IS = (unit.getInternal(location) * 2);
            double allocate = Math.min(IS * percent, pointsToAllocate);
            switch (location) {
                case Mech.LOC_HEAD:
                    break;
                case Mech.LOC_CT:
                case Mech.LOC_LT:
                case Mech.LOC_RT:
                    double rear = Math.floor(allocate * .25);
                    double front = Math.ceil(allocate * .75);
                    pointsToAllocate -= (int) rear;
                    pointsToAllocate -= (int) front;
                    unit.initializeArmor((int) front, location);
                    getMech().initializeRearArmor((int) rear, location);
                    break;
                default:
                    unit.initializeArmor((int) allocate, location);
                    pointsToAllocate -= (int) allocate;
                    break;
            }
        }
        allocateLeftoverPoints(pointsToAllocate);

        refresh();
        if (refresh != null) {
            refresh.refreshStatus();
        }
    }

    /**
     * allocate any leftover points one-by-one
     *
     * @param points
     *            the amount of points left over
     */
    private void allocateLeftoverPoints(double points) {
        while (points >= 1) {
            // if two or more are left, add armor to symmetrical locations,
            // to torso, legs, arms, in that order
            if (points >= 2) {
                if ((unit.getOArmor(Mech.LOC_LT) + unit.getOArmor(Mech.LOC_LT, true) < (unit.getOInternal(Mech.LOC_LT) * 2)) && (unit.getOArmor(Mech.LOC_RT) + unit.getOArmor(Mech.LOC_RT, true) < (unit.getOInternal(Mech.LOC_RT) * 2))) {
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_LT) + 1, Mech.LOC_LT);
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_RT) + 1, Mech.LOC_RT);
                    points -= 2;
                } else if ((unit.getOArmor(Mech.LOC_LLEG) < (unit.getOInternal(Mech.LOC_LLEG) * 2)) && (unit.getOArmor(Mech.LOC_RLEG) < (unit.getOInternal(Mech.LOC_RLEG) * 2))) {
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_LLEG) + 1, Mech.LOC_LLEG);
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_RLEG) + 1, Mech.LOC_RLEG);
                    points -= 2;
                } else if ((unit.getOArmor(Mech.LOC_LARM) < (unit.getOInternal(Mech.LOC_LARM) * 2)) && (unit.getOArmor(Mech.LOC_RARM) < (unit.getOInternal(Mech.LOC_RARM) * 2))) {
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_LARM) + 1, Mech.LOC_LARM);
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_RARM) + 1, Mech.LOC_RARM);
                    points -= 2;
                }
                // otherwise, first add to the head, and then even out uneven
                // allocation
            } else if (unit.getOArmor(Mech.LOC_HEAD) < 9) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_HEAD) + 1, Mech.LOC_HEAD);
                points--;
            } else if (unit.getOArmor(Mech.LOC_LT) < unit.getOArmor(Mech.LOC_RT)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_LT) + 1, Mech.LOC_LT);
                points--;
            } else if (unit.getOArmor(Mech.LOC_RT) < unit.getOArmor(Mech.LOC_LT)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_RT) + 1, Mech.LOC_RT);
                points--;
            } else if (unit.getOArmor(Mech.LOC_RARM) < unit.getOArmor(Mech.LOC_LARM)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_RARM) + 1, Mech.LOC_RARM);
                points--;
            } else if (unit.getOArmor(Mech.LOC_LARM) < unit.getOArmor(Mech.LOC_RARM)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_LARM) + 1, Mech.LOC_LARM);
                points--;
            } else if (unit.getOArmor(Mech.LOC_RLEG) < unit.getArmor(Mech.LOC_LLEG)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_RLEG) + 1, Mech.LOC_RLEG);
                points--;
            } else if (unit.getOArmor(Mech.LOC_LLEG) < unit.getOArmor(Mech.LOC_RLEG)) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_LLEG) + 1, Mech.LOC_LLEG);
                points--;
                // if nothing is uneven, add to the CT
            } else if ((unit.getOArmor(Mech.LOC_CT) + unit.getOArmor(Mech.LOC_CT, true) < (unit.getOInternal(Mech.LOC_CT) * 2))) {
                unit.initializeArmor(unit.getOArmor(Mech.LOC_CT) + 1, Mech.LOC_CT);
                points--;
            }
            // if only one is left, and head and CT have max, remove one from CT
            // so symmetric locations can get extra, unless they are already at
            // max
            if (points == 1) {
                if ((unit.getOArmor(Mech.LOC_HEAD) == 9) && ((unit.getOArmor(Mech.LOC_CT) + unit.getOArmor(Mech.LOC_CT, true)) == unit.getOInternal(Mech.LOC_CT) * 2)) {
                    unit.initializeArmor(unit.getOArmor(Mech.LOC_CT) - 1, Mech.LOC_CT);
                    points++;
                }
            }
            // if all locations have max, return
            boolean toReturn = true;
            for (int location = 0; location < unit.locations(); location++) {
                double is = (unit.getInternal(location) * 2);
                switch (location) {
                    case Mech.LOC_HEAD:
                        if (is + 3 > unit.getOArmor(location)) {
                            toReturn = false;
                        }
                        break;
                    case Mech.LOC_CT:
                    case Mech.LOC_LT:
                    case Mech.LOC_RT:
                        if (is > unit.getOArmor(location) + unit.getOArmor(location, true)) {
                            toReturn = false;
                        }
                        break;
                    default:
                        if (is > unit.getOArmor(location)) {
                            toReturn = false;
                        }
                        break;
                }
            }
            if (toReturn) {
                return;
            }
        }
    }

    public void stateChanged(ChangeEvent e) {
        JSpinner field = (JSpinner) e.getSource();
        int location = Integer.parseInt(field.getName());
        int value = (Integer) field.getModel().getValue();
        switch (location) {
            case Mech.LOC_CT:
                if (field.equals(ctrArmorField)) {
                    getMech().initializeRearArmor(value, location);
                } else {
                    unit.initializeArmor(value, location);
                }
                break;
            case Mech.LOC_RT:
                if (field.equals(rtrArmorField)) {
                    getMech().initializeRearArmor(value, location);
                } else {
                    unit.initializeArmor(value, location);
                }
                break;
            case Mech.LOC_LT:
                if (field.equals(ltrArmorField)) {
                    getMech().initializeRearArmor(value, location);
                } else {
                    unit.initializeArmor(value, location);
                }
                break;
            default:
                unit.initializeArmor(value, location);
                break;
        }
        if (refresh != null) {
            refresh.refreshArmor();
            refresh.refreshStatus();
        }
        refresh();
    }
}