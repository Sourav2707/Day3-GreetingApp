package com.bridgelabz.mygreetingapp.reposirtoy;

import com.bridgelabz.mygreetingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long> {
}
