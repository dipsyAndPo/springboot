package cn.yyt.springboot.pojo;

import javax.persistence.*;

@Entity
@Table(name = "typeinfo")
public class TypeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeid")
    private int typeId;
    @Column(name = "typename")
    private String typeName;

    public TypeInfo(String typeName) {
        this.typeName = typeName;
    }

    public TypeInfo() {
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return "TypeInfo{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
