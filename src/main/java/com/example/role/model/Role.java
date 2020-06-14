package com.example.role.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "role")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {

    @ApiModelProperty(hidden = true)
    @Id
    private String id;

    @Indexed(name = "nic", unique = true)
    private String nic;

    private String organization;

    private String fName;

    private String lName;

    private String type;

    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
