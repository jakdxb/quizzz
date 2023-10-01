package com.zuchowiczjakub.quizzz.repository;


import com.zuchowiczjakub.quizzz.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    // Tutaj możesz dodać niestandardowe metody dostępu do bazy danych, jeśli są potrzebne.
}

