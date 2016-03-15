/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen6461.ui;

import com.soen6461.analysis.AnalysisFacade;
import com.soen6461.models.ScrappedModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author khurram
 */
public class BarChart extends javax.swing.JInternalFrame {

    /**
     * Creates new form BarChart
     */
    ArrayList<javax.swing.JCheckBox> checkBoxes;
    ScrappedModel scrappedModel;
    HashMap<String, ArrayList<String>> scrappedData;
    AnalysisFacade analysisFacade;
    ArrayList<String> stringKeys = new ArrayList<String>() {{
    add("contentRating");
    add("numDownloads");
    add("operatingSystems");
    add("datePublished");
    add("AppName");
    add("Url");
}};
    public BarChart() {

        initComponents();
        //JOptionPane.showInputDialog("hello");
        AnalysisFacade facade = AnalysisFacade.getInstance();

        ArrayList<String> keys = facade.getAvailableKeys();

        Iterator itr = keys.iterator();
        jPanel1.setLayout(new GridLayout(Math.round(keys.size() / 2) + 1, Math.round(keys.size() / 2) + 1, 4, 4));
        checkBoxes = new ArrayList<>();
        while (itr.hasNext()) {
            //System.out.println(itr.next());
            String name = (String) itr.next();
            javax.swing.JCheckBox box = new javax.swing.JCheckBox(name);
            jPanel1.add(box);
            box.setName(name);
            checkBoxes.add(box);
        }
        analysisFacade = AnalysisFacade.getInstance();
        scrappedData = analysisFacade.getScrappedModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_barGraph = new javax.swing.JButton();
        btn_pie_chart = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonExportRDF = new javax.swing.JButton();
        jButtonHelp = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        btn_barGraph.setText("Bar Graph");
        btn_barGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barGraphActionPerformed(evt);
            }
        });

        btn_pie_chart.setText("Pie Graph");
        btn_pie_chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pie_chartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btn_barGraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(btn_pie_chart)
                .addGap(66, 66, 66))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_barGraph)
                    .addComponent(btn_pie_chart))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButtonExportRDF.setText("Export RDF");
        jButtonExportRDF.setEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jButtonExportRDF)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonExportRDF)
                .addContainerGap())
        );

        jButtonHelp.setText("Help");
        jButtonHelp.setEnabled(false);

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonHelp)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonHelp)
                    .addComponent(jButtonExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_barGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barGraphActionPerformed
        ArrayList<ArrayList<String>> selectedCheckBoxes = new ArrayList<>();
        ArrayList<String> dataPoints = new ArrayList<>();
        int tag = -1; //keep track of string key
        int selectedCount = 0;
        String title = "";
        Iterator itr  = checkBoxes.iterator();
        for (javax.swing.JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                if(stringKeys.contains(cb.getName()))
                    tag=selectedCount;
                selectedCheckBoxes.add(scrappedData.get(cb.getName()));
                System.out.println("Adding: "+cb.getName());
                dataPoints.add(cb.getName());
                title = title.concat(cb.getName()).concat(" vs ");
                System.out.println(title);
                selectedCount++;
            }
        }
        title = title.substring(0, (title.length())-3);
        System.out.println(title);  
        System.out.println("Tag= "+tag +" SelectedCount= "+selectedCount);
        System.out.println("Datapoints before: "+selectedCheckBoxes);
        int totalValues = selectedCheckBoxes.get(0).size();
        if(tag>=0)
        {
            Collections.swap(selectedCheckBoxes,tag,selectedCount-1);
            Collections.swap(dataPoints,tag,selectedCount-1);
        }
        
        
        
        System.out.println("Datapoints after: "+selectedCheckBoxes);
       // ArrayList<Integer> applicationParamInteger = new ArrayList<Integer>();

        
        // TODO add your handling code here:

        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        System.out.println(totalValues);
        for (int k = 0; k < totalValues; k++) {
            System.out.println(selectedCheckBoxes.get(0).get(k) + "***");
            System.out.println(selectedCheckBoxes.get(1).get(k));
              ds.setValue(Double.parseDouble(selectedCheckBoxes.get(0).get(k)), "Downloads", selectedCheckBoxes.get(1).get(k));
        }
        
        JFreeChart chart = ChartFactory.createBarChart(title, dataPoints.get(1), dataPoints.get(0), ds, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLACK);
        //ChartFrame frame = new ChartFrame("Bar Chart for Apps", chart);
        ChartPanel CP = new ChartPanel(chart);
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(CP,BorderLayout.CENTER);
        jPanel3.validate();
       // frame.setVisible(true);
       // frame.setSize(450, 350);

    }//GEN-LAST:event_btn_barGraphActionPerformed

    private void btn_pie_chartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pie_chartActionPerformed


    }//GEN-LAST:event_btn_pie_chartActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jCheckBoxAppNameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBoxAppRatingActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBoxAppScoreActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jCheckBoxAppFiveStarsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_barGraph;
    private javax.swing.JButton btn_pie_chart;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonExportRDF;
    private javax.swing.JButton jButtonHelp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
