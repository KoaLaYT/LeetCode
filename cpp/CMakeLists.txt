cmake_minimum_required(VERSION 3.19)

# My vcpkg root dir
set(ENV{VCPKG_ROOT} "/Users/koalayt/Library")
set(CMAKE_TOOLCHAIN_FILE "$ENV{VCPKG_ROOT}/Vcpkg/scripts/buildsystems/vcpkg.cmake"
    CACHE STRING "")

project(LeetCode)

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_CXX_EXTENSIONS OFF)

find_package(GTest CONFIG REQUIRED)

add_subdirectory(20210527_3Sum_Closest)
add_subdirectory(20210528_4Sum)
add_subdirectory(20210529_Divide_Two_Integers)
add_subdirectory(20210529_Next_Permutation)
add_subdirectory(20210601_Valid_Sudoku)
add_subdirectory(20210615_Count_and_Say)
add_subdirectory(20210617_Combination_Sum)
add_subdirectory(20210626_Combination_Sum_Ⅱ)
add_subdirectory(20210627_Multiply_Strings)
add_subdirectory(20210629_Jump_Game_2)
add_subdirectory(20210704_Permutations_2)
add_subdirectory(20210704_Rotate_Image)