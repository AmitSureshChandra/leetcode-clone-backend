package com.github.amitsureshchandra.leetcodeclone.dto.req;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CodeRunReq {
    private String code;
    private String compiler;
    private List<String> testCases;
}
