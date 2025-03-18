package com.example.model;

import java.util.Date;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "tweets") // Changed from "locations" to "tweets" for consistency
public class TweetInfo {
    @Id
    private String id;

    @NotBlank
    @Size(max = 240)
    private String text;

    @CreatedDate
    @NotNull
    private Date createdAt = new Date(); // Automatically set when created
}
