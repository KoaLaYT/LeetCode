add_library("20210704_Permutations_2" solution.cpp)

add_executable("20210704_Permutations_2_Test" solution_test.cpp)
target_link_libraries("20210704_Permutations_2_Test" PRIVATE "20210704_Permutations_2" GTest::gtest GTest::gtest_main)