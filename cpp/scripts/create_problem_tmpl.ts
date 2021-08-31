import * as path from "https://deno.land/std@0.97.0/path/mod.ts";
import { format } from "https://deno.land/std@0.97.0/datetime/mod.ts";

function replaceWhitespaces(name: string): string {
    return name.replace(/\s+/g, "_").trim();
}

function today(): string {
    return format(new Date(), "yyyyMMdd");
}

function main() {
    const [baseDir, problemName] = Deno.args;
    const encoder = new TextEncoder();

    const createFile = (name: string, content: string) => {
        Deno.writeFileSync(
            path.join(baseDir, dirname, name),
            encoder.encode(content)
        );
    };

    // [1] mkdir
    const dirname = `${today()}_${replaceWhitespaces(problemName)}`;
    Deno.mkdirSync(dirname);
    // [2] templates cpp files
    createFile(
        "CMakeLists.txt",
        `add_library("${dirname}" solution.cpp)\n\nadd_executable("${dirname}_Test" solution_test.cpp)\ntarget_link_libraries("${dirname}_Test" PRIVATE "${dirname}" GTest::gtest GTest::gtest_main)`
    );
    createFile(
        "solution.hpp",
        `#ifndef SOLUTION_HPP_${dirname}\n#define SOLUTION_HPP_${dirname}\n\n\n#endif`
    );
    createFile("solution.cpp", `#include "solution.hpp"\n`);
    createFile(
        "solution_test.cpp",
        `#include "solution.hpp"\n#include <gtest/gtest.h>\n`
    );
    // [3] update CMakeLists
    Deno.writeFileSync(
        path.join(baseDir, "CMakeLists.txt"),
        encoder.encode(`\nadd_subdirectory(${dirname})`),
        { append: true }
    );
}

main();
