add_library("20210627_Multiply_Strings" solution.cpp)

add_executable("20210627_Multiply_Strings_Test" solution_test.cpp)
target_link_libraries("20210627_Multiply_Strings_Test" PRIVATE "20210627_Multiply_Strings" GTest::gtest GTest::gtest_main)