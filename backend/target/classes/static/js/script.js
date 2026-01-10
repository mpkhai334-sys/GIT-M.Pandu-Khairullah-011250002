const form = document.getElementById('regForm');
const messages = document.getElementById('messages');
const viewList = document.getElementById('viewList');
const listSection = document.getElementById('listSection');
const registrationsEl = document.getElementById('registrations');

function showMessage(text, ok=true){
  messages.textContent = text;
  messages.style.color = ok ? 'green' : 'crimson';
}

form.addEventListener('submit', async (e)=>{
  e.preventDefault();
  const fd = new FormData(form);
  const payload = Object.fromEntries(fd.entries());
  try{
    const res = await fetch('/api/register', {
      method: 'POST',
      headers: {'Content-Type':'application/json'},
      body: JSON.stringify(payload)
    });
    if(!res.ok) throw new Error('Gagal mendaftar');
    const data = await res.json();
    showMessage('Pendaftaran berhasil — ID: '+data.id);
    form.reset();
  }catch(err){
    showMessage(err.message||'Error', false);
  }
});

viewList.addEventListener('click', async ()=>{
  try{
    const res = await fetch('/api/registrations');
    const arr = await res.json();
    registrationsEl.innerHTML = '';
    arr.forEach(r=>{
      const li = document.createElement('li');
      li.textContent = `${r.name} — ${r.email} — ${r.category || ''}`;
      registrationsEl.appendChild(li);
    });
    listSection.classList.remove('hidden');
  }catch(e){
    showMessage('Gagal mengambil daftar', false);
  }
});
