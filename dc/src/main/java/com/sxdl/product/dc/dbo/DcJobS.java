package com.sxdl.product.dc.dbo;

import com.sxdl.product.dc.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class DcJobS {

    private DcJob dcJob;
    private List<DcTransfer> transferList;
    private List<DcRequestAPI> requestAPIList;
    private List<DcProcedure> procedureList;
    private List<DcTableVsTable> dcTableVsTableList;
    private List<DcVirtualTable> dcVirtualTableList;
    private List<DcSchedule> dcScheduleList;
    private List<DcTable> dcTableList;
    private List<DcColumn> dcColumnList;
    private DcHospital dcHospital;
}
