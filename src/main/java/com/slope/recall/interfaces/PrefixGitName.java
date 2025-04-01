package com.slope.recall.interfaces;

// + have default, static, or override object equals/hashcode/tostring
@FunctionalInterface
public interface PrefixGitName {
    String transform(String name);
} 