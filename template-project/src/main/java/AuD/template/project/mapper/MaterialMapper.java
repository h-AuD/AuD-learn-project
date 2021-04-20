package AuD.template.project.mapper;


import AuD.template.project.model.entity.Material;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    // 批量更新素材
    public Integer updateMaterials(@Param("materials") List<Material> materials);

    // 更新素材
    public Integer updateMaterial(Material material);

    // 批量插入素材
    public Integer insertMaterials(@Param("materials") List<Material> materials);

    // 插入素材
    public int insertMaterial(Material material);

    public String selectMaterialIsExistByMediaIdAndSeq(@Param("mediaId") String mediaId, @Param("seq") int seq);

}
