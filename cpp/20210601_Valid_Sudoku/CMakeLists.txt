add_library("20210601_Valid_Sudoku" solution.cpp)

add_executable("20210601_Valid_Sudoku_Test" solution_test.cpp)
target_link_libraries("20210601_Valid_Sudoku_Test" PRIVATE "20210601_Valid_Sudoku" GTest::gtest GTest::gtest_main)