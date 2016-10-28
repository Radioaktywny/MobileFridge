package org.mobilefridge.domain.objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Marcin on 28.10.2016.
 */
//@MappedSuperclass
public class TransactionalEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String referenceId = UUID.randomUUID().toString();

    @Version
    private Integer version;

    @NotNull
    private Date createdAt;

    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        if(this.id==null){
            return -1;
        }
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            TransactionalEntity objTE = (TransactionalEntity) obj;
            if (this.getId() == null || objTE.getId() == null) {
                return false;
            }
            if (this.getId().equals(objTE.getId())) {
                return true;
            }
        }
        return false;
    }
    @PrePersist
    public void beforePersist(){
        setCreatedAt(new Date());
    }

    @PreUpdate
    public void beforeUpdate(){
        setUpdatedAt(new Date());
    }
}
