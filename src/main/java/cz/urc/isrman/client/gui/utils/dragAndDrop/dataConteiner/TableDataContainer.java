package cz.urc.isrman.client.gui.utils.dragAndDrop.dataConteiner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Jakub
 */
public class TableDataContainer {

    private String id;
    private double layoutX;
    private double layoutY;
    private String headerLabel;
    private String headerValue;
    private List<TableDataRow> rows = new ArrayList<>();
    private HashMap<String, String> connections = new HashMap<>();
    private HashMap<String, List<String>> connectionsActivities = new HashMap<>();
    private Integer hierarchy;

    /**
     *
     * @param id
     * @param headerLabel
     * @param headerValue
     */
    public TableDataContainer(String id, String headerLabel, String headerValue) {
        this.id = id;
        this.headerLabel = headerLabel;
        this.headerValue = headerValue;
    }

    /**
     *
     * @param id
     * @param headerLabel
     * @param headerValue
     * @param hierarchy
     */
    public TableDataContainer(String id, String headerLabel, String headerValue, Integer hierarchy) {
        this.id = id;
        this.headerLabel = headerLabel;
        this.headerValue = headerValue;
        this.hierarchy = hierarchy;
    }

    /**
     *
     */
    public TableDataContainer() {
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getHeaderLabel() {
        return headerLabel;
    }

    /**
     *
     * @param headerLabel
     */
    public void setHeaderLabel(String headerLabel) {
        this.headerLabel = headerLabel;
    }

    /**
     *
     * @return
     */
    public String getHeaderValue() {
        return headerValue;
    }

    /**
     *
     * @param headerValue
     */
    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    /**
     *
     * @return
     */
    public List<TableDataRow> getRows() {
        return rows;
    }

    /**
     *
     * @param rows
     */
    public void setRows(List<TableDataRow> rows) {
        this.rows = rows;
    }

    /**
     *
     * @return
     */
    public double getLayoutX() {
        return layoutX;
    }

    /**
     *
     * @param layoutX
     */
    public void setLayoutX(double layoutX) {
        this.layoutX = layoutX;
    }

    /**
     *
     * @return
     */
    public double getLayoutY() {
        return layoutY;
    }

    /**
     *
     * @param layoutY
     */
    public void setLayoutY(double layoutY) {
        this.layoutY = layoutY;
    }

    /**
     *
     * @return
     */
    public HashMap<String, String> getConnections() {
        return connections;
    }

    /**
     *
     * @return
     */
    public Integer getHierarchy() {
        return hierarchy;
    }

    /**
     *
     * @param hierarchy
     */
    public void setHierarchy(Integer hierarchy) {
        this.hierarchy = hierarchy;
    }

    /**
     *
     * @param connections
     */
    public void setConnections(HashMap<String, String> connections) {
        this.connections = connections;
    }

    public HashMap<String, List<String>> getConnectionsActivities() {
        return connectionsActivities;
    }

    @Override
    public String toString() {
        return "TableDataContainer{" + "id=" + id + ", layoutX=" + layoutX + ", layoutY=" + layoutY + ", headerLabel=" + headerLabel + ", headerValue=" + headerValue + ", rows=" + rows + ", connections=" + connections + ", hierarchy=" + hierarchy + '}';
    }

    /**
     *
     */
    public static class TableDataRow {

        private String id;
        private String label;
        private String value;

        /**
         *
         * @param id
         * @param label
         * @param value
         */
        public TableDataRow(String id, String label, String value) {
            this.id = id;
            this.label = label;
            this.value = value;
        }

        /**
         *
         */
        public TableDataRow() {
        }

        /**
         *
         * @return
         */
        public String getLabel() {
            return label;
        }

        /**
         *
         * @param label
         */
        public void setLabel(String label) {
            this.label = label;
        }

        /**
         *
         * @return
         */
        public String getValue() {
            return value;
        }

        /**
         *
         * @param value
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         *
         * @return
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         */
        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "TableDataRow{" + "id=" + id + ", label=" + label + ", value=" + value + '}';
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 43 * hash + Objects.hashCode(this.id);
            hash = 43 * hash + Objects.hashCode(this.label);
            hash = 43 * hash + Objects.hashCode(this.value);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final TableDataRow other = (TableDataRow) obj;
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            if (!Objects.equals(this.label, other.label)) {
                return false;
            }
            if (!Objects.equals(this.value, other.value)) {
                return false;
            }
            return true;
        }

        /**
         *
         * @return
         */
        public boolean isEmpty() {
            if ((label != null && !label.isEmpty()) || (value != null && !value.isEmpty())) {
                return false;
            }

            return true;
        }

    }
}
