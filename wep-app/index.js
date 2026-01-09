async function calculate() {
    const n1 = num1.value.trim();
    const n2 = num2.value.trim();

    if (!n1 || !n2) {
        alert("Vui lòng nhập đủ hai số");
        return;
    }

    const stepsDiv = document.getElementById("steps");
    const processBox = document.getElementById("process");
    const resultBox = document.getElementById("result");

    stepsDiv.innerHTML = "";
    processBox.classList.remove("d-none");
    resultBox.classList.add("d-none");

    try {
        const res = await fetch("http://localhost:8080/a2n/sum", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ stn1: n1, stn2: n2 })
        });

        const data = await res.json();
        if (data.code !== 1000) {
            alert(data.message || "Lỗi");
            return;
        }

        const steps = data.result.step;
        let i = 0;

        const timer = setInterval(() => {
            if (i >= steps.length) {
                clearInterval(timer);

                document.getElementById("finalResult").innerText =
                    data.result.result;
                resultBox.classList.remove("d-none");
                return;
            }

            if (steps[i].trim() !== "") {
                const p = document.createElement("div");
                p.className = "mb-1 border-bottom pb-1";
                p.innerText = steps[i];
                stepsDiv.appendChild(p);

                stepsDiv.scrollTop = stepsDiv.scrollHeight;
            }

            i++;
        }, 200);

    } catch (err) {
        console.error(err);
        alert("Không kết nối được server");
    }
}
