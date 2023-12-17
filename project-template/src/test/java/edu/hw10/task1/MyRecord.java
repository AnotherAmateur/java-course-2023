package edu.hw10.task1;

record MyRecord(@Max(Integer.MIN_VALUE + 1) int intValue, @NotNull String str) {
}
