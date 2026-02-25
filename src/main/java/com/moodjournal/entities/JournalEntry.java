package com.moodjournal.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@Component
public class JournalEntry {
    @Id
    private ObjectId id;
    private String title;
    private String mood;
}
