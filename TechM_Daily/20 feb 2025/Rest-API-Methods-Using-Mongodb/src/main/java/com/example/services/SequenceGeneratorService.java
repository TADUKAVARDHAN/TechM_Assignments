package com.example.services;

import java.util.Objects;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import com.example.model.DataSequence;

public class SequenceGeneratorService {
	private MongoOperations mongo;
	public long generateSequence(String seqName) {
		DataSequence d=mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq",1), options().returnNew(true).upsert(true),DataSequence.class);
		return !Objects.isNull(d)? d.getSeq() : 1;
	}
}
