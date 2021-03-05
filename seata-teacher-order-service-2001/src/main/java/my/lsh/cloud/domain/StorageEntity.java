package my.lsh.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StorageEntity {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
