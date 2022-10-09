package com.plants.exceptions;

import lombok.Value;
import java.util.List;

@Value
public class ProblemDetail {
    String title;
    List<Violation> violationList;
}
