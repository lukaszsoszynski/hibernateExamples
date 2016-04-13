package com.impag.training.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Name {

    @Column(nullable = false)
    private String first;

    @NotNull
    private String middle;

    @Column(nullable = false)
    private String last;
}
