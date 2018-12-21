package com.bl.qa.component.common.atlas;

public enum AtlasSideBarFieldSection {
    FIELDS,

    GROUP,

    MEASURE,

    PIVOT_COLUMNS,

    ROW_GROUPS,

    SORTING;

    @Override
    public String toString() {
        switch(this) {
            case FIELDS: return "Fields";
            case GROUP: return "Group";
            case MEASURE: return "Measure";
            case PIVOT_COLUMNS: return "Pivot Columns";
            case ROW_GROUPS: return "Row Groups";
            case SORTING: return "Sorting";
            default: throw new IllegalArgumentException();
        }
    }
}
