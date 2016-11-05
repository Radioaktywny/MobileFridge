package org.mobilefridge.objects;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

//@MappedSuperclass
class TransactionalEntity implements Serializable {

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

    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    private void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        if (this.id == null) {
            return -1;
        }
        return this.getId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
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
    public void beforePersist() {
        setCreatedAt(new Date());
    }

    @PreUpdate
    public void beforeUpdate() {
        setUpdatedAt(new Date());
    }
}
