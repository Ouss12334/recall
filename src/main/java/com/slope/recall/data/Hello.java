package com.slope.recall.data;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor // needed for builder when specify @noargs
@NoArgsConstructor // needed for JPA "List<T> findBy"
public class Hello {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String who;

    private void setId(String id) { 
        // do nothing  to block setting id by @Data
    }

}
