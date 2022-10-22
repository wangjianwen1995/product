package com.sxdl.hp.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DcBaseProceEntity {
    String name;
    String isparam;
    String timeColumnName;
}
