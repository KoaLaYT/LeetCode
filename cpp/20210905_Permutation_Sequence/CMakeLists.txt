add_library("20210905_Permutation_Sequence" solution.cpp)

add_executable("20210905_Permutation_Sequence_Test" solution_test.cpp)
target_link_libraries("20210905_Permutation_Sequence_Test" PRIVATE "20210905_Permutation_Sequence" GTest::gtest GTest::gtest_main)